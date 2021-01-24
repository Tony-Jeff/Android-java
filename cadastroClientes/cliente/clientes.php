<?php

ini_set('display_errors',1);
ini_set('log_errors',1);
ini_set('errors_log',dirname(__FILE__).'/error_log.txt');
error_reporting(E_ALL);

//Definindo o Time zone
date_default_timezone_set('America/Sao_Paulo');

//Criando a conecxaão com o banco de dados
$mysqli = new mysqli('localhost','id6581351_tonyjeff','senac2018','id6581351_cadastrocliente');

//Criando a consulta
$sql = "SELECT * FROM cliente ORDER BY nome";

//Executando a consulta
$res = $mysqli->query($sql);

//criando array para o JSON
$clientes = array();

//Exibindo os registros
while($row = mysqli_fetch_array($res)){
    $clientes[] = array("id"=>$row["id"], "nome"=>$row["nome"], "sobrenome"=>$row["sobrenome"]);
}

echo json_encode(array("cliente"=>$clientes));

?>