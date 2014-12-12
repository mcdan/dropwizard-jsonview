<#-- @ftlvariable name="" type="com.example.helloworld.views" -->
<html>
    <body>
        <h1>${saying.content?html}!</h1>
        <h2>Num times ${saying.id?html}</h2>
        <a href="#" id="jsonHook">Via JSON!</a>
        
	<script>
		function getJSON() {
			var req = new XMLHttpRequest();
			req.onload = function() {
				console.debug("got stuff");
			};
			req.open("GET", document.location.pathname);
			req.setRequestHeader("Accept", "application/json");
			req.send();
		}
		document.getElementById("jsonHook").addEventListener("click", getJSON);
	</script>
    </body>
</html>