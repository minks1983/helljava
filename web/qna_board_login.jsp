<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="./resources/css/bootstrap.min.css" />
    <title>로그인</title>
</head>
<body>
    <form class="form-horizontal">
        <div class="form-group">
            <label for="id" class="col-sm-2 control-label">Id</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="id" name="id" placeholder="id">
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-sm-2 control-label">Password</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="password" name="password" placeholder="Password">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <div class="checkbox">
                    <label>
                        <input type="checkbox"> Remember me
                    </label>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" formmethod="post" class="btn btn-default" formaction="./LoginAction.wo">Sign in</button>
            </div>
        </div>
    </form>
</body>
</html>
