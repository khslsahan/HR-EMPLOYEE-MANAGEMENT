<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--@elvariable id="employee" type="com.hsenid.headerfooterjsp.model.Employee"--%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <div class="container border rounded m-3 p-3">
        <h1 class="text-center m-5">${action} EMPLOYEE</h1>
        <div class="row d-flex justify-content-center">
        <div class="col-12 col-md-6 border rounded  border-dark border-2 p-3 ">

            <form:form action="/saveEmployee" method="post" modelAttribute="employee">
                <form:hidden path="id.id" />
<%--                <form:hidden path="id.departmentId" />--%>
                <input type="hidden" name="action" value="${action}" />
                <div class="form-group">
                    <label for="department" class="m-2">Department:</label>
                    <form:select path="id.departmentId" id="department" class="form-control m-2">
                        <form:options items="${departments}" itemLabel="name" itemValue="id" />
                    </form:select>
                </div>
                <div class="form-group">
                    <label for="firstName" class="m-2">First Name:</label>
                    <form:input path="firstName" id="firstName" class="form-control m-2" />
                </div>
                <div class="form-group">
                    <label for="lastName" class="m-2">Last Name:</label>
                    <form:input path="lastName" id="lastName" class="form-control m-2" />
                </div>
                <div class="form-group">
                    <label for="nic" class="m-2">NIC:</label>
                    <form:input path="nic" id="nic" class="form-control m-2" />
                </div>
                <div class="form-group">
                    <label for="email" class="m-2">Email:</label>
                    <form:input path="email" id="email" class="form-control m-2" />
                </div>
                <div class="form-group">
                    <label for="mobilePhone" class="m-2">Mobile Phone:</label>
                    <form:input path="mobilePhone" id="mobilePhone" class="form-control m-2" />
                </div>
                <div class="form-group">
                    <label for="joinedYear" class="m-2">Joined Year:</label>
                    <fmt:formatDate pattern="yyyy" value="${employee.joinedYear}" var="joinedYear"/>
                    <form:input path="joinedYear" id="joinedYear" class="form-control m-2" value="${joinedYear}" />
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
    </div>
</div>