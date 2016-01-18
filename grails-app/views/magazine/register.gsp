<%@ page import="labmmba.Usuario;labmmba.Keyword; labmmba.Magazine; labmmba.InvestigationArea" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
</head>

<br>
<h1>Agregar Publicacion Revista</h1>
<br class="nav" role="navigation">
    <g:form controller="magazine" action="upload" enctype="multipart/form-data" useToken="true">
        <BR/>
        <input hidden value="1" name="autors" id="counter1"/>
        <input hidden value="1" name="keywords" id="counter2"/>
        <input hidden value="${usuarioInstance.id}" name="id"/>
        Titulo articulo<input type="text" placeholder="Titulo" name="paper" />
        </br>
        <INPUT type="button" value="Agregar otro Autor" onclick="add1(document.forms[0].select)"/>
        <span id="fooBar1">&nbsp;</span>
        </br>
        <INPUT type="button" value="Agregar keyword" onclick="add2(document.forms[0].select)"/>
        <span id="fooBar2">&nbsp;</span>
        </br>
        Año Publicacion<input type="text" placeholder="Año" name="year" />
        </br>
        Revista<input type="text" placeholder="Revista1" name="magazine" list="magazines"/>
        <datalist id="magazines">
            <g:each in="${labmmba.Magazine.getAll()}" var="magazine">
                <option value="${magazine.magazineName}"/>
            </g:each>
        </datalist>
        </br>
        Area<input type="text" placeholder="otro" name="area" list="areas"/>
        <datalist id="areas">
            <g:each in="${labmmba.InvestigationArea.getAll()}" var="area">
                <option value="${area.name}"/>
            </g:each>
        </datalist>
        </br>
        <input type="file" name="filecsv"/>
        <input type="submit" class="upload" value="upload"/>
        </span>
    </g:form>
    <button><g:link controller="project" action="index" id="${usuarioInstance.id}">volver</g:link></button>
</div>

<SCRIPT language="javascript">

    var j = 0;
    var k = 0;
    function add1() {

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
        var foo = document.getElementById("fooBar1");

        //Append the element in page (in span).
        foo.appendChild(element);
        for (var i = 0; i < arrayId.length; i++) {
            var option = document.createElement("option");
            option.value = arrayId[i];
            option.text = arrayName[i]+" "+arrayLastName[i];
            element.appendChild(option);
        }
        var total=document.getElementById("counter1");
        total.setAttribute("value",j)
    }
    function add2() {
            k=k+1;
            //Create an input type dynamically.
            var element = document.createElement("input");
            var array = [
                <g:each in="${labmmba.Keyword.getAll()}" var="keyword">
                "${keyword.name}" ,
                </g:each>
            ];
            //Assign different attributes to the element.
            element.setAttribute("type", "text");
            element.setAttribute("placeholder","keyword"+k);
            element.setAttribute("name", "keyword"+k);
            element.setAttribute("list","keywords");
            var foo = document.getElementById("fooBar2");

            //Append the element in page (in span).
            foo.appendChild(element);
            var list=document.createElement("datalist");
            list.setAttribute("id","keywords");
            foo.appendChild(list);
            for (var i = 0; i < array.length; i++) {
                var option = document.createElement("option");
                option.value = array[i];
                list.appendChild(option);
            }
            var total=document.getElementById("counter2");
            total.setAttribute("value",k)
    }
</SCRIPT>
</body>


</html>

