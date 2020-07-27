<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="Grails"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>
    <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.3/build/pure-min.css" integrity="sha384-cg6SkqEOCV1NbJoCu11+bm0NvBRc8IYLRGXkmNrqUBfTjmMYwNKPWBTIKyw9mHNJ" crossorigin="anonymous">
    <asset:stylesheet src="application.css"/>
    <g:layoutHead/>
</head>

<body>
<div id="layout">
    <!-- Menu toggle -->
    <a href="#menu" id="menuLink" class="menu-link">
        <!-- Hamburger icon -->
        <span></span>
    </a>

    <div id="menu">
        <div class="pure-menu">
            <a class="pure-menu-heading" href="#">Mayberry</a>

            <ul class="pure-menu-list">
                <li class="pure-menu-item"><a href="/" class="pure-menu-link">Home</a></li>
                <li class="pure-menu-item"><a href="/about" class="pure-menu-link">About</a></li>

                <li class="pure-menu-item menu-item-divided">
                    <a href="/component" class="pure-menu-link">Components</a>
                </li>
                <li class="pure-menu-item menu-item-divided">
                    <a href="/ports" class="pure-menu-link">Available Ports</a>
                </li>
                <li class="pure-menu-item menu-item-divided">
                    <a href="/squad" class="pure-menu-link">Squads</a>
                </li>
                <li class="pure-menu-item menu-item-divided">
                    <a href="/login" class="pure-menu-link">Login</a>
                </li>

                <li class="pure-menu-item"><a href="/contact" class="pure-menu-link">Contact</a></li>
            </ul>
        </div>
    </div>

    <div id="main">
        <div class="header">
            <g:img dir="images" file="Mayberry.png" width="200" height="200"/>
            <h2>Developer Portal</h2>
            <h2>Mayberry is a platform to manage your microservices architecture on your team.</h2>
            <p>
            Powered by Gitlab <g:img dir="images" file="/stack/gitlab.svg" width="20" height="20"/><p>
            </p>
        
        </div>

        <div class="content">
            <g:layoutBody/>
        </div>
    </div>
</div>




<asset:javascript src="application.js"/>

</body>
</html>
