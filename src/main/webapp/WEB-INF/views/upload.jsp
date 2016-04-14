<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<%@include file="jspf/header.jspf" %>


<div class="well">
    <strong>Please browse xml file for uploading: </strong>
    <form:form method="post" enctype="multipart/form-data" modelAttribute="uploadedFile" action="uploadFile">
        <table>
            <tr>
                <td>Upload File:</td>
                <td><input type="file" title="Search for a file to add" name="file"/></td>
                <td style="color: red; font-style: italic;"><form:errors path="file"/></td>
                <span style="color: green; float: left" id="success">${success}</span>

            </tr>
            <p>&nbsp;</p>
            <tr>
                <td><input type="submit" class="btn btn-lg btn-primary" value="Upload"/></td>
            </tr>
        </table>
    </form:form>
</div>


<script src="/resources/js/bootstrap.file-input.js"></script>
<script>
    $(document).ready(function () {
        $('input[type=file]').bootstrapFileInput();
    });
</script>

<%@include file="jspf/footer.jspf" %>

