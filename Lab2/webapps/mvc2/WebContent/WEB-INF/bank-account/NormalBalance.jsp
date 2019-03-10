<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>Your Balance</TITLE>
<LINK REL=STYLESHEET
      HREF="./bank-support/JSP-Styles.css"
      TYPE="text/css">
</HEAD>
<BODY>
<TABLE BORDER=5 ALIGN="CENTER">
  <TR><TH CLASS="TITLE">
      Your Balance</TABLE>
<P>
<IMG SRC="./bank-support/Money.gif" ALIGN="RIGHT">
<UL>
  <LI>First name: ${customer.firstName}
  <LI>Last name: ${customer.lastName}
  <LI>ID: ${customer.id}
  <LI>Balance: $${customer.balance}
</UL>      
</BODY></HTML>