<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>MVC Examples</TITLE>
<LINK REL=STYLESHEET
      HREF="./bank-support/JSP-Styles.css"  
      TYPE="text/css">
</HEAD>
<BODY>
<fieldset>
  <legend>Bank Account Balance</legend>
  <%-- Use the .../show-balance address that is set in web.xml instead of
       the invoker servlet address of .../servlet/coreservlets.ShowBalance --%>
  <form action="./show-balance">
    Customer ID (id001, id002, id003): <input type="text" name="id"><br>
    <input type="submit" value="Show Balance">
  </form>
</fieldset>
<br>
<fieldset>
  <legend>Random Number</legend>
  <form action="./random-number"> <%-- Address from web.xml  --%>
    Range:  <input type="text" name="range"><br/>
    <input type="submit" value="Show Number">
  </form>
</fieldset>
<br>
<fieldset>
  <legend>Registration</legend>
  <form action="./register"> <%-- Address from web.xml  --%>
    First name: <input type="text" name="firstName"><br>
    Last name: <input type="text" name="lastName"><br>
    <input type="submit" value="Register">
  </form>
</fieldset>
<br>
<fieldset>
  <legend>Prime Number</legend>
  <form action="./prime"> <%-- Address from web.xml  --%>
    Length: <input type="text" name="primeLength"><br>
    <input type="submit" value="Calculate Prime">
  </form>
</fieldset>

<BR><BR><BR><BR><BR>
<FONT SIZE="-2">All code from the
<A HREF="http://courses.coreservlets.com/Course-Materials/">
coreservlets.com J2EE tutorials (servlets, JSP, Struts, JSF, Ajax, GWT, Spring, Hibernate, JPA, 
&amp; Java 6 programming).</A>. There are also live instructor-led
<A HREF="http://courses.coreservlets.com/">training courses on
the same J2EE topics (servlets, JSP, Struts, JSF, Ajax, GWT, Spring, Hibernate, JPA, 
&amp; Java 6 programming)</A>.
</FONT>
</BODY></HTML>