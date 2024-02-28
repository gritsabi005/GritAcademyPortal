
<table id="data table">
    <c:forEach items="${dataCourses}" var="dataPunkt">
         <tr>
        <c:forEach items="${dataPunkt}" var="dataPunktKolumn">
                <td>${dataPunktKolumn}</td>
        </c:forEach>
         </tr>
    </c:forEach>
</table>
