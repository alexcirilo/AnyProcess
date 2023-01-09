# AnyProcess
<div align="center">
<h3>Software para Cadastro de Processos</h3>
</div>

<h2 align="center"> Ferramentas </h2>
<div align="center">

<td><img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" height="30" width="40"/></td>
<td>Java 8</td>

<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" height="30" width="40"/>
<td>Spring MVC 5.3.23</td>

<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/tomcat/tomcat-original.svg" height="30" width="40"/>
<td>TomCat 8.5.83</td>
<br>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/mysql/mysql-original.svg" height="30" width="40"/>
<td>MySQL 5.7</td>

<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/bootstrap/bootstrap-original.svg" height="30" width="40"/>
<td>Bootstrap 4.6</td>
<br>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/intellij/intellij-original.svg" height="30" width="40"/>
<td>Intellij IDEA 2022.2.3 (Community Edition)</td>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/docker/docker-original.svg" height="30" width="40"/>
<td>Docker 20.10.22 & Docker Compose v1.29.2</td>


</div>
<hr/>
<h2>Processos para execução da aplicação:</h2>
<tr>
    <td>1. A aplicação fará todo o deploy em container docker. Então, execute comando via docker-compose: </td>
    <pre>docker-compose up -d --build anyprocess</pre>
    <td>Isso irá carregar o banco de dados, que está com configurações no IP <strong>172.21.0.2</strong> e a aplicação que está com IP: <strong>172.21.0.3</strong></td><br>
    <td>Após finalizar, o container ficará rodando em 2° plano. Acesse a aplicação no navegador via url:</td>
    <pre><a href="http://172.21.0.3:8080">http://172.21.0.3:8080</a></pre>

</tr>
