<?php

ini_set('display_errors',1);
ini_set('log_errors',1);
ini_set('errors_log',dirname(__FILE__).'/error_log.txt');
error_reporting(E_ALL);



//Definindo o Time zone
date_default_timezone_set('America/Sao_Paulo');

//Criando a conecxaão com o banco de dados
$mysqli = new mysqli('localhost','id6591884_senac','senac','id6591884_senac');


//Cliente para ser excluido
$email = $_GET["email"];
$senha = $_GET["senha"];

//Criando consulta
$sql = "SELECT * FROM usuario WHERE email = '".$email."' AND senha = '".$senha."'";



//Executando a consulta
$res = $mysqli->query($sql);


//Verificação se o usúario existe
if(mysqli_num_rows($res)>0){
    echo "OK";
}else{
    echo "ERRO";
}

?>