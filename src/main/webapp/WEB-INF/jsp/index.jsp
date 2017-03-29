<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>

    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"/>

    <spring:url value="/css/main.css" var="springCss"/>
    <spring:url value="/js/main.js" var="mainJs"/>

    <link href="${springCss}" rel="stylesheet"/>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <script src="${mainJs}"></script>

</head>
<body>

<div id="index-tab" class="container">
    <ul class="nav nav-pills">
        <li class="active">
            <a href="#import" data-toggle="tab">Import</a>
        </li>
        <li >
            <a href="#about" data-toggle="tab">About</a>
        </li>
    </ul>

    <div class="tab-content clearfix">
        <div class="tab-pane active" id="import">
            <form class="form-inline media-import-form">
                <div class="form-group">
                    <label for="media-type">Media content type:</label>
                    <select class="form-control" id="media-type" name="mediaType">
                    </select>
                </div>
                <div class="form-group">
                    <label for="title">Title:</label>
                    <input type="text" class="form-control" id="title" name="title">
                </div>
                <div class="form-group">
                    <label for="year">Year:</label>
                    <input type="text" class="form-control" id="year" name="year">
                </div>
                <button type="button" id="import-media-btn" class="btn btn-default">Import media</button>
            </form>
        </div>
        <div class="tab-pane" id="about">
            <h3>Hi! You came on the media content downloader</h3>
        </div>
    </div>
</div>


</body>

</html>
