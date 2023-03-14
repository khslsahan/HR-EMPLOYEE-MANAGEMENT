<nav class="navbar navbar-expand-lg navbar-dark ">
    <div class="container-fluid ">
        <a class="navbar-brand" href="#">
            <img src="hr.png" alt="HR" class="img-fluid" style="max-height: 50px;">
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item ${pageContext.request.requestURI.contains('/home') ? 'active' : ''}">
                    <a class="nav-link" href="/">Home</a>
                </li>
                <li class="nav-item ${pageContext.request.requestURI.contains('/departmentList') ? 'active' : ''}">
                    <a class="nav-link" href="/departmentList">Department</a>
                </li>
                <li class="nav-item ${pageContext.request.requestURI.contains('/employeeList') ? 'active' : ''}">
                    <a class="nav-link" href="/employeeList">Employee</a>
                </li>
            </ul>
            <form class="d-flex">
                <a class="btn btn-dark" href="/login" role="button">Logout</a>
            </form>
        </div>
    </div>
</nav>