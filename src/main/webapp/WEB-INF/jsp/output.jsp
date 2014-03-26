<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>

        <script type="text/javascript"
        src="https://ajax.googleapis.com/ajax/libs/jquery/1.8/jquery.min.js"></script>
        <script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
        <script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>


    </head>
    <body>
        <h2>Infonal Project</h2>
        <div id="errorMessage" hidden="true">
            <p>&nbsp;There are error(s)</p>
            <ul />
        </div>
        <script src="<c:url value="/resources/js/crud.js" />"></script>
        <script src="<c:url value="/resources/js/UserValidator.js" />"></script>

        <script src="<c:url value="/resources/js/confirmation.js" />"></script>

        <form id="userForm" name="userForm" onsubmit="return addUser();"  >
            <input type="hidden" id="userId" name="id">
            <label for="name">Name</label>
            <input type="text" id="name" name="name"/>
            <label for="surname">Surname</label>
            <input type="text" id="surname" name="surname"/>
            <label for="phoneNumber">Phone Number</label>
            <input type="text" id="phoneNumber" name="phoneNumber"/>





            <img src="jcaptcha.jpg" id ="jcapthcaimg"/> <input type="text" name="jcaptcha" id="jcaptcha" value="" />
            <a href="#" id="refreshCaptcha" onclick="refreshCaptcha();">Refresh captcha</a>

            <img id="img" style="display: none" src="http://dev.cloudcell.co.uk/bin/loading.gif"/>   

            <input type="submit"   id="submitForm"  value="Submit" />
        </form>

        <table border="1" id="userTable">
            <c:forEach  var="user" items="${userList}" varStatus="loop">
                <tr>
                    <td>${user.name}</td>
                    <td>${user.surname}</td>
                    <td>${user.phoneNumber}</td>
                    <td><input class="delClass" index="${loop.index}" type="button" id="deleteButton_${loop.index}" value="delete"/></td>


                    <td style="display: none"><input    class="hiddenDelClass" index="${loop.index}" type="button" id="hiddenDeleteButton_${loop.index}" value="delete" onclick="deleteUser('${user.id}')"/></td>
                    <td style="display: none"><div id="dialog-confirm_${loop.index}"></div></td> 
                <div style="display: none" id="dialog-edit_${loop.index}">




                </div>
            </tr>
        </c:forEach>
    </table>  



</body>
</html> 