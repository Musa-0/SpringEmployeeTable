
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--подключаем цакл для нашего списка работников-->
<!DOCTYPE html>
<html>
<body>
<h2>All Employee</h2>
<br>
<table>
	<tr>

		<th>Name</th>
		<th>Surname</th>
		<th>Department</th>
		<th>Salary</th>
		<th>Options</th><!--укажем наши шапки-->
	</tr><!--строка таблицы-->
	<c:forEach var="emp" items="${allEmps}"><!--указывам временную переменную, и сам список по которому будем прохадиться-->
		<tr>
			<td>${emp.name}</td>
			<td>${emp.surname}</td>
			<td>${emp.department}</td>
			<td>${emp.salary}</td><!--указываем наши ячейки-->
            <td><input type="button" value="Update" onclick="window.location.href = 'updateEmployee/${emp.id}'"></td>
            <td><input type="button" value="Delete" onclick="window.location.href = 'deleteEmployee/${emp.id}'"></td>

		</tr>
	</c:forEach><!--цикл, который выведет все данные из списка работников-->

</table><!--создадим таблицу со строками наших работников-->

<br>
<input type="button" value="Add" onclick = "window.location.href = 'addEmployee'"/>
</body>
</html>
