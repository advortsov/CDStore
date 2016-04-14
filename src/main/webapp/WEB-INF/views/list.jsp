<!DOCTYPE html>
<%@include file="jspf/header.jspf" %>

<div class="container">
    <div class="well">
        <strong>List of CDs</strong>
    </div>
    <table class="table table-stripped">
        <tr>
            <th>Title</th>
            <th>Artist</th>
            <th>Country</th>
            <th>Company</th>
            <th>Price</th>
            <th>Year</th>
        </tr>
        <c:forEach items="${cds}" var="cd" varStatus="itr">
            <tr>
                <td>${cd.title}</td>
                <td>${cd.artist}</td>
                <td>${cd.country}</td>
                <td>${cd.company}</td>
                <td>${cd.price}</td>
                <td>${cd.year}</td>
            </tr>
        </c:forEach>
    </table>
    <tag:paginate max="15" offset="${offset}" count="${count}"
                  uri="/" next="&raquo;" previous="&laquo;"/>
</div>

<%@include file="jspf/footer.jspf" %>
