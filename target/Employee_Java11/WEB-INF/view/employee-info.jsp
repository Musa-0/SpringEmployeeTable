<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<body>

<h2>Employee Info</h2>
<br>

<form:form action="/saveEmployee" modelAttribute="employee"><!--формачка в которую мы передали нашу модель для заполнения-->
	<form:hidden path="id"/><!--создадим тут раздел id скрыв его для того, чтобы если это будет создание нового пользователя
	то id будет всегда равен нулю, и при сохранении мы понимали что если id=0 то надо создавать нвого пользователя
	а если не ноооль, то значит надо менять уже созданного-->
	Name <form:input path="name"/>
	<br><br>
	Surname <form:input path="surname"/>
	<br><br>
	Department <form:input path="department"/>
	<br><br>
	Salary <form:input path="salary"/>
	<br><br>
	<input type="submit" value="OK">


</form:form>

</body>
</html>