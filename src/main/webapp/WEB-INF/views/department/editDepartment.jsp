<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--@elvariable id="department" type="com.hsenid.headerfooterjsp.model.Department"--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<div class="container">
    <h1 class="text-center m-5">${action}  DEPARTMENT</h1>
    <div class="row d-flex justify-content-center">
        <div class="col-12 col-md-6 ">
            <form:form action="/saveDepartment" method="post" modelAttribute="department">
            <form:hidden path="id" />
                <div class="form-group" >
                    <label for="name" class="m-3">Name:</label>
                    <form:input path="name" id="name" class="form-control m-3 "  disabled="${action} === 'VIEW'" />
                </div>
                <c:if test="${action ne 'VIEW'}">
                <div class="d-flex justify-content-end">
                    <button type="submit" class="btn btn-primary mt-4 m-2">
                        <i class="fas fa-save"></i> ${action}
                    </button>
                </div>
                </c:if>
            </form:form>
        </div>
    </div>
    <c:if test="${action eq 'VIEW'}">
    <div class="table-responsive mt-5">
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
    </c:if>
</div>