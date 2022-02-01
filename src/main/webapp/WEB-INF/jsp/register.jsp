<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="./css/style.css">
<title>Insert title here</title>
</head>
<body>
    <div class="form_wrapper">
        <div class="form_container">
          <div class="title_container">
            <h2>Responsive Registration Form</h2>
          </div>
          <div class="row clearfix">
            <div class="">
              <form action="<%=request.getContextPath()%>/register" method="post" >
                <div class="input_field"> <span><i aria-hidden="true" class="fa fa-envelope"></i></span>
                  <input type="text" name="username" placeholder="Username" required />
          
                </div>
                <div class="input_field"> <span><i aria-hidden="true" class="fa fa-lock"></i></span>
                  <input type="password" name="password" placeholder="Password" required />
                </div>
                <div class="row clearfix">
                  <div class="col_half">
                    <div class="input_field"> <span><i aria-hidden="true" class="fa fa-user"></i></span>
                      <input type="text" name="prenom" placeholder="First Name" />
                    </div>
                  </div>
                  <div class="col_half">
                    <div class="input_field"> <span><i aria-hidden="true" class="fa fa-user"></i></span>
                      <input type="text" name="nom" placeholder="Last Name" required />
                    </div>
                  </div>
                </div>

                <input class="button" type="submit" value="Register" />
              </form>
            </div>
          </div>
        </div>
      </div>
      <p class="credit">Developed by <a href="http://www.designtheway.com" target="_blank">Design the way</a></p>
</body>
</html>