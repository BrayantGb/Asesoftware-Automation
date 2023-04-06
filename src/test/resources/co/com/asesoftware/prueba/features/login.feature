#language: es
#Author: Brayant Gamboa Betancur

@RegressionTest
 Característica: Realizar el login de un usuario
  Yo como usuario
  Necesito realizar el login en la pagina ciencuadras.com
  Para así poder llenar un formulario de solicitud de arriendo

  @LogueoExitoso
 Esquema del escenario: Realizar un login exitoso en la pagina ciencuadras.com
  Dado El usuario ingresa a la pagina
  Cuando el usuario diligencia los campos necesario <IdPrueba>
  Entonces se valida que haya un logueo exitoso
  Y despues de loguearse cierra la sesion
   Ejemplos:
    |IdPrueba  |
    |1         |
