package com.dvortsov.cdstore.controller;


import com.dvortsov.cdstore.controller.validators.FileValidator;
import com.dvortsov.cdstore.service.interfaces.CDService;
import com.dvortsov.cdstore.service.objects.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
@SessionAttributes("filename")
@RequestMapping("/file")
public class FileController {

    @Autowired
    private CDService cdService;

    @Autowired
    private FileValidator fileValidator;

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String upload() {
        return "upload.jsp";
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView uploadFile(@ModelAttribute("uploadedFile") UploadedFile uploadedFile, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();
        MultipartFile file = uploadedFile.getFile();
        fileValidator.validate(uploadedFile, result);
        if (result.hasErrors()) {
            modelAndView.setViewName("upload.jsp");
            return modelAndView;
        } else {
            try {
                cdService.parseXmlAndSave(multipartToFile(file));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        modelAndView.addObject("success", "File has been uploaded!");
        modelAndView.setViewName("upload.jsp");
        return modelAndView;
    }

    public File multipartToFile(MultipartFile multipart) throws IllegalStateException, IOException {
        File convFile = new File(multipart.getOriginalFilename());
        multipart.transferTo(convFile);
        return convFile;
    }
}
