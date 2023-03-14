<footer id="footer-fx" >
<div class="bg-primary py-3">
    <div class="container ">
        <div class="row">
            <div class="col-12 col-md-4  ">
                <h5>About Our Product</h5>
                <p>manage employee data, track employee time and attendance, manage payroll, handle benefits administration, and more. With HSednid HR System</p>
            </div>
            <div class="col-12 col-md-4  ">
                <h5>Connect With Us</h5>
                <ul class="list-unstyled">
                    <li><a href="#" class="text-dark text-decoration-none"><i class="fab fa-facebook text-dark"></i> Facebook</a></li>
                    <li><a href="#" class="text-dark text-decoration-none"><i class="fab fa-twitter text-dark"></i> Twitter</a></li>
                    <li><a href="#" class="text-dark text-decoration-none"><i class="fab fa-instagram text-dark"></i> Instagram</a></li>
                </ul>
            </div>
            <div class="col-12 col-md-4  ">
                <h5>Our Partners</h5>
                <ul class="list-unstyled ">
                    <li><a href="#" class="text-dark text-decoration-none"><img src="" alt="Partner Logo"></a></li>
                    <li><a href="#" class="text-dark text-decoration-none"><img src="" alt="Partner Logo"></a></li>
                    <li><a href="#" class="text-dark text-decoration-none"><img src="" alt="Partner Logo"></a></li>
                </ul>
            </div>
        </div>
    </div>
</div>
<div class="bg-dark py-3">
    <div class="container d-flex justify-content-center">
        <span  class="text-white"> Copyright &copy; 1997-2023 hSenid Mobile Solutions. All Rights Reserved. | Sitemap | Privacy policy </span>
    </div>
</div>
</footer>
<script>
    function adjustFooter() {
        var body = document.body;
        var html = document.documentElement;
        var docHeight = Math.max(body.scrollHeight, body.offsetHeight, html.clientHeight, html.scrollHeight, html.offsetHeight);
        console.log(docHeight,window.innerHeight)
        if (docHeight <= window.innerHeight) {
            document.querySelector('#footer-fx').classList.add('fixed-bottom');
            console.log("Add fixed")
        } else {
            document.querySelector('#footer-fx').classList.remove('fixed-bottom');
            console.log("remover Fixes")
        }
    }
    window.addEventListener('resize', adjustFooter);
    adjustFooter();
</script>