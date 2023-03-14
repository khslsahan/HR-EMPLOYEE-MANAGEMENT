<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <h1 class="text-center m-5"> DEPARTMENTS</h1>
    <div class="d-flex justify-content-start mb-3">
        <a href="/addDepartment" class="btn btn-primary">
            <i class="fas fa-plus mr-2"></i> Add Department
        </a>
    </div>
    <div class="table-responsive ">
        <table class="table table-striped table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>View</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <!-- add department rows here -->
        <c:forEach var="department" items="${departments}">
            <tr>
                <td>${department.id}</td>
                <td>${department.name}</td>
                <td><a href="/viewDepartment/${department.id}"><i class="fas fa-eye"></i></a></td>
                <td><a href="/editDepartment/${department.id}"><i class="fas fa-edit"></i></a></td>
                <td><a href="/deleteDepartment/${department.id}"><i class="fas fa-trash"></i></a></td>

            </tr>
        </c:forEach>

        </tbody>
    </table>
    </div>

</div>