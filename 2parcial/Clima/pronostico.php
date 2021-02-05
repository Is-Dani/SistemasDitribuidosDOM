<?php
include('conexion.php');

//var_dump($_SERVER['argv']);
if (!isset($_SERVER['PATH_INFO'])) {
    $ruta = "/";
} else {
    $ruta = $_SERVER['PATH_INFO'];
}


$arregloRuta = explode('/', $ruta);
// var_dump($arregloRuta);

$recurso = $arregloRuta[1];

if (isset($arregloRuta[2])) {
    $id = $arregloRuta[2];
    // echo ' recurso= ' . $recurso . ' id=' . $id;
}
// var_dump($_SERVER['argv']);
// var_dump($_POST);
// var_dump($_REQUEST);

// parse_str(file_get_contents("php://input"),$put_vars);
// var_dump($put_vars);


// foreach ($_SERVER as $s => $valor) {
//     echo $s.$valor;
// }
if ($recurso == 'pronostico') {
    switch ($_SERVER['REQUEST_METHOD']) {
        case 'GET': //Recuperar
            if (isset($id)) {
                $sql = "SELECT * from pronostico WHERE id=$id";
            } else {
                $sql = "SELECT * from pronostico";
            }
            $resultado = $con->query($sql);

            $filas = array();
            while ($r = mysqli_fetch_assoc($resultado)) {
                $filas[] = $r;
            }
            print json_encode($filas);
            break;
        case 'POST': //Grabar
            $fecha = $_POST['fecha'];
            $temperatura = $_POST['temperatura'];
            $porcentaje = $_POST['porcentaje'];

            $sql = "insert into pronostico(fecha, temperatura, porcentaje) values('$fecha', '$temperatura', '$porcentaje')";
            $resultado = $con->query($sql);
            if ($resultado)
                echo 'se inserto con exito';
            else
                echo "hubo un error";
            break;
        case 'PUT': //actualizar
            // print $_SERVER['PATH'];
            parse_str(file_get_contents("php://input"), $put_vars);
            $fecha = $put_vars['fecha'];
            $temperatura = $put_vars['temperatura'];
            $porcentaje = $put_vars['porcentaje'];


            if (isset($id)) {
                $sql = "UPDATE pronostico set fecha = '$fecha', temperatura = '$temperatura', porcentaje = '$porcentaje' WHERE id=$id";
                $resultado = $con->query($sql);
                $sql2 = "SELECT * from pronostico WHERE id=$id";
                $resultado2 = $con->query($sql2);

                print json_encode(mysqli_fetch_assoc($resultado2));
            } else {
                http_response_code(404);
                
            }
            break;


        case 'PATCH': //actualizacion parcial
            parse_str(file_get_contents("php://input"), $put_vars);
            if (isset($id)) {
                if (isset($put_vars['fecha'])) {
                    $fecha = $put_vars['fecha'];
                    $sql = "UPDATE pronostico set fecha ='$fecha'";
                }
                if (isset($put_vars['temperatura'])) {
                    $temperatura = $put_vars['temperatura'];
                    $sql = "UPDATE pronostico set temperatura ='$temperatura' WHERE id=$id";
                }
                if (isset($put_vars['porcentaje'])) {
                    $porcentaje = $put_vars['porcentaje'];
                    $sql = "UPDATE pronostico set porcentaje ='$porcentaje' WHERE id=$id";
                }
                $resultado = $con->query($sql);
                $sql2 = "SELECT * from pronostico WHERE id=$id";
                $resultado2 = $con->query($sql2);
                print json_encode(mysqli_fetch_assoc($resultado2));
            } else {
                http_response_code(404);
            }
            break;
        case 'DELETE': //Borrar

            if (isset($id)) {
                $sql2 = "SELECT * from pronostico WHERE id=$id";
                $resultado2 = $con->query($sql2);
                // var_dump($resultado2);
                if ($resultado2) {
                    print json_encode(mysqli_fetch_assoc($resultado2));
                    $sql = "DELETE from pronostico WHERE id=$id";
                    $resultado = $con->query($sql);
                } else {
                    http_response_code(404);
                }
            } else {
                http_response_code(404);
            }
            break;
    }
}
