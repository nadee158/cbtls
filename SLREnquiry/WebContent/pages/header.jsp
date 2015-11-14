<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>

<script type="text/javascript">
var min = 10;
var reset = 12;
var max = 14;

function increaseAllFont() {
	increaseFontSize('input');
	increaseFontSize('td');
	increaseFontSize('a');
	increaseFontSize('select');
	increaseFontSize('span');
	increaseFontSize('textarea');
	increaseFontSize('th');
	increaseFontSize('label');
}

function decreaseAllFont() {
	decreaseFontSize('input');
	decreaseFontSize('td');
	decreaseFontSize('a');
	decreaseFontSize('select');
	decreaseFontSize('span');
	decreaseFontSize('textarea');
	decreaseFontSize('th');
	decreaseFontSize('label');
}

function resetAllFont() {
	defaultFontSize('input');
	defaultFontSize('td');
	defaultFontSize('a');
	defaultFontSize('select');
	defaultFontSize('span');
	defaultFontSize('textarea');
	defaultFontSize('th');
	defaultFontSize('label');
}

function increaseFontSize(elem) {
   var p = document.getElementsByTagName(elem);
   var unit = "px";
   for(i = 0; i < p.length; i++) {
      if(p[i].style.fontSize) {
		if(p[i].style.fontSize.search("px")>0)
		{
         	var s = parseInt(p[i].style.fontSize.replace("px",""));
		}
		else if(p[i].style.fontSize.search("pt")>0)
		{
	 		var s = parseInt(p[i].style.fontSize.replace("pt",""));
	 		unit = "pt";
		}
		else{
	 		var s = reset;
		}
      } else {
         var s = reset;
      }
      if(s != max) {
         s += 1;
      }
      p[i].style.fontSize = s + unit ;
   }
}


function defaultFontSize(elem) {
	var p = document.getElementsByTagName(elem);
	var unit = "px";
    var s = reset;
    for(i=0; i<p.length; i++) {
      if(p[i].style.fontSize) {
	 	if(p[i].style.fontSize.search("pt")>0)
		{
	 		unit = "pt";
		}
	    p[i].style.fontSize = s+ unit ;
	  }
	}
}


function decreaseFontSize(elem) {
   var p = document.getElementsByTagName(elem);
   var unit = "px";
   for(i=0; i<p.length; i++) {
      if(p[i].style.fontSize) {
		if(p[i].style.fontSize.search("px")>0)
		{
        	var s = parseInt(p[i].style.fontSize.replace("px",""));
		}
		else if(p[i].style.fontSize.search("pt")>0)
		{
	 		var s = parseInt(p[i].style.fontSize.replace("pt",""));
	 		unit = "pt";
		}
		else {
	 		var s = reset;
	}
      } else {
         var s = reset;
      }
      if(s != min) {
         s -= 1;
      }
      p[i].style.fontSize = s + unit ;
   }
}

function changeLocale(locale) {
	var url = "homeAction.action?lang=" + locale;
	window.location = url;
}

</script>

<style type="text/css">		
#es_header_top {
	background:url(images/top_bar_bg.png) no-repeat;
    background-position: center top;
    background-repeat: no-repeat;
    height: 100px;
}

#es_header_navbar {
	background-color: #33559B;
}

</style>


<div id="es-header">
<header>
	<div id="es_header_top">
	<table style="width:27%;float:right;">
		<tr>
			<td width="40%">
				<table style="width:100%;">
					<tr>
						<td align="left"><a href="http://www.gov.lk/" target="_blank"><img src="images/gov.png" /></a></td>
						
						<s:set name="locale" value="selectedLocale"/>
						<s:if test="%{#locale !='en'}">
							<td align="center"><a href="#" onclick="changeLocale('en')"><img src="images/en.gif" /></a></td>
						</s:if>
						
						<s:if test="%{#locale != 'si'}">
							<td align="center"><a href="#" onclick="changeLocale('si')"><img src="images/si.gif" /></a></td>
						</s:if>
						
						<s:if test="%{#locale !='ta'}">
							<td align="right"><a href="#" onclick="changeLocale('ta')"><img src="images/ta.gif" /></a></td>
						</s:if>
					</tr>
				</table>
			</td>
			<td width="60%" rowspan="2" id="font_controller" style="font-size:13px">
			</td>
		</tr>
		<tr>
			<td>
				<table style="width:100%;">
					<tr>
						<td><a href="http://www.siyabas.lk/sinhala_how_to_install.html" target="_blank"><img src="images/sinhala.jpg"/></a></td>
						<td><a href="http://www.emathumozhihal.lk/tamil_how_to_install_in_english.html" target="_blank"><img src="images/tamil.jpg" /></a></td>
						<td><a href="#" onclick="increaseAllFont()"><img src="images/1.jpg" /></a></td>
						<td><a href="#" onclick="decreaseAllFont()"><img src="images/2.jpg" /></a></td>
						<td><a href="#" onclick="resetAllFont()"><img src="images/3.jpg" /></a></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	</div>
	<div id="es_header_navbar">
  			<table style="width:100%; height: 40px">
  				<tr>
  					<td width="15%">
  						&nbsp;
  					</td>
  					<td width="85%">
  						<a href="http://www.railway.gov.lk/web/index.php" target="_blank"><font color="white"><s:text name="enquiry.SLR.Home" /></font></a>
  					</td>
  				</tr>
  			</table>
	</div>
</header>
</div>




