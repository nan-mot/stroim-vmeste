<%--
  Created by IntelliJ IDEA.
  User: Наташенька
  Date: 29.05.2022
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search for projects</title>
    <style>
        .frmSearch {
            border: 1px solid #a8d4b1;
            background-color: #c6f7d0;
            margin: 2px 0px;
            padding: 40px;
            border-radius: 4px;
        }

        #country-list {
            float: left;
            list-style: none;
            margin-top: -3px;
            padding: 0;
            width: 190px;
            position: absolute;
        }

        #country-list li {
            padding: 10px;
            background: #f0f0f0;
            border-bottom: #bbb9b9 1px solid;
        }

        #country-list li:hover {
            background: #ece3d2;
            cursor: pointer;
        }

        #search-box {
            padding: 10px;
            border: #a8d4b1 1px solid;
            border-radius: 4px;
        }
    </style>
    <script src="https://code.jquery.com/jquery-2.1.1.min.js" type="text/javascript"></script>
    <script>
        // AJAX call for autocomplete
        $(document).ready(function () {
            $("#search-box").keyup(function () {
                $.ajax({
                    type: "POST",
                    url: "/projects/search",
                    data: 'keyword=' + $(this).val(),
                    beforeSend: function () {
                        $("#search-box").css("background", "#FFF url(https://phppot.com/demo/jquery-ajax-autocomplete-country-example/loaderIcon.gif) no-repeat 165px");
                    },
                    success: function (data) {
                        $("#suggesstion-box").show();
                        $("#suggesstion-box").html(data);
                        $("#search-box").css("background", "#FFF");
                    }
                });
            });
        });

        //To select country name
        function selectCountry(val) {
            $("#search-box").val(val);
            $("#suggesstion-box").hide();
        }
    </script>
</head>
<body>
<div class="frmSearch">
    <input type="text" id="search-box" placeholder="Project name"/>
    <div id="suggesstion-box"></div>
</div>
</body>
</html>
