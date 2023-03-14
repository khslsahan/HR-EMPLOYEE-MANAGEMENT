<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="employee" type="com.hsenid.headerfooterjsp.model.Employee"--%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="container">
    <h1 class="text-center m-5"> EMPLOYEES</h1>
    <div class="d-flex justify-content-start mb-3">
        <a href="/addEmployee" class="btn btn-primary">
            <i class="fas fa-plus mr-2"></i> Add Employee
        </a>
    </div>
    <div class="table-responsive">
      <table class="table table-striped table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Department</th>
            <th>Nic</th>
            <th>Email</th>
            <th>Mobile No.</th>
            <th>Joined Year</th>

            <th>View</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <!-- add department rows here -->
        <c:forEach var="employee" items="${employees}">
            <tr>
                <td>${employee.id.id}</td>
                <td>${employee.firstName} ${employee.lastName}</td>
                <td>${employee.department.name}</td>
                <td>${employee.nic}</td>
                <td>${employee.email}</td>
                <td>${employee.mobilePhone}</td>
                <%-- Extract year from employee.joinedYear using JSP EL --%>

                <td>${fn:substring(employee.joinedYear, 0, 4)}</td>

                <td><a href="/viewEmployee/${employee.id.id}"><i class="fas fa-eye"></i></a></td>
                <td><a href="/editEmployee/${employee.id.id}"><i class="fas fa-edit"></i></a></td>
                <td><a href="/deleteEmployee/${employee.id.id}"><i class="fas fa-trash-alt"></i></a></td>

            </tr>
        </c:forEach>

        </tbody>
    </table>
    </div>


</div>