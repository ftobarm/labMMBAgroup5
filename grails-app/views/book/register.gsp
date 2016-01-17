<%@ page import="labmmba.Usuario;" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
</head>

<body>
<h1>Agregar Publicacion</h1>
<div class="nav" role="navigation">
    <g:form controller="book" action="upload" enctype="multipart/form-data" useToken="true">
        <BR/>
        <input hidden value="1" name="autors" id="counter"/>
        <input hidden value="${usuarioInstance.id}" name="id"/>
        <input type="text" placeholder="Titulo" name="title" />
        </br>
        <INPUT type="button" value="Agregar otro Autor" onclick="add(document.forms[0].select)"/>
        <span id="fooBar">&nbsp;</span>
        </br>
        <input type="text" placeholder="Año" name="year" />
        </br>
        <input type="text" placeholder="Editorial" name="editorial" />
        </br>
        <input type="text" placeholder="ISBN" name="isbn" />
        </br>
        <input type="file" name="filecsv"/>
        <input type="submit" class="upload" value="upload"/>
        </span>
    </g:form>
    <button><g:link controller="project" action="index" id="${usuarioInstance.id}">volver</g:link></button>
</div>

<SCRIPT language="javascript">

    var j = 0;
    function add() {

        j=j+1;
        //Create an input type dynamically.
        var element = document.createElement("Select");
        var arrayId = [
            <g:each in="${labmmba.Usuario.getAll()}" var="user1">
                "${user1.id}" ,
            </g:each>
            ];
        var arrayName = [
            <g:each in="${labmmba.Usuario.getAll()}" var="user2">
            "${user2.nombre}" ,
            </g:each>
        ];
        var arrayLastName = [
            <g:each in="${labmmba.Usuario.getAll()}" var="user3">
            "${user3.apellido}",
            </g:each>
        ];
        //Assign different attributes to the element.
        element.setAttribute("name", "autor"+j);
        var foo = document.getElementById("fooBar");

        //Append the element in page (in span).
        foo.appendChild(element);
        for (var i = 0; i < arrayId.length; i++) {
            var option = document.createElement("option");
            option.value = arrayId[i];
            option.text = arrayName[i]+" "+arrayLastName[i];
            element.appendChild(option);
        }
        var total=document.getElementById("counter");
        total.setAttribute("value",j)
    }
</SCRIPT>
</body>


</html>

