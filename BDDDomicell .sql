--
-- Base de datos: `restaurante`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `CLI_ID` int(11) AUTO_INCREMENT,
  `CLI_NOMBRE` varchar(100) NOT NULL,
  `CLI_CARRERA` int(11) NOT NULL,
  `CLI_CALLE` int(11) NOT NULL,
  `CLI_FOTO` longblob DEFAULT NULL,
  `CLI_TIPO` varchar(100) NOT NULL CHECK (`CLI_TIPO` IN ('ADMINISTRADOR','COMPRADOR')),
  `CLI_CONTRASENIA` varchar(11) NOT NULL,
  CONSTRAINT PK_CLIENTE PRIMARY KEY (`CLI_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menudia`
--

CREATE TABLE `menudia` (
  `MEND_ID` int(11) AUTO_INCREMENT,
  `RES_ID` int(11) NOT NULL,
  `MEND_DIASEM` varchar(10) NOT NULL CHECK (`MEND_DIASEM` IN ('LUNES','MARTES','MIERCOLES','JUEVES','VIERNES','SABADO','DOMINGO')),
  CONSTRAINT PK_MENUDIA PRIMARY KEY (`MEND_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menuespecial`
--

CREATE TABLE `menuespecial` (
  `MENE_ID` int(11) AUTO_INCREMENT,
  `RES_ID` int(11) NOT NULL,
  CONSTRAINT PK_MENUESPECIAL PRIMARY KEY (`MENE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

CREATE TABLE `pedido` (
  `PED_ID` int(11) AUTO_INCREMENT,
  `CLI_ID` int(11) NOT NULL,
  `RES_ID` int(11) NOT NULL,
  `PED_ESTADO` varchar(10) DEFAULT 'CREADO' CHECK (`PED_ESTADO` in ('CREADO','CANCELADO','PAGADO')),
  `PED_FECHA_CREADO` datetime  DEFAULT NOW(),
  `PED_FECHA_PAGADO` datetime ,
  CONSTRAINT PK_PEDIDO PRIMARY KEY (`PED_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `platoespecial`
--

CREATE TABLE `platoespecial` (
  `PLAE_ID` int(11) AUTO_INCREMENT,
  `MENE_ID` int(11) NOT NULL,
  `PLAE_NOMBRE` varchar(100) NOT NULL,
  `PLAE_FOTO` longblob DEFAULT NULL,
  `PLAE_DESCRIPCION` varchar(100) DEFAULT NULL,
  `PLAE_PRECIO` int(11) NOT NULL,
  CONSTRAINT PK_PLATOESPECIAL PRIMARY KEY (`PLAE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `platoespecialpedido`
--

CREATE TABLE `platoespecialpedido` (
  `PLAEP_ID` int(11) AUTO_INCREMENT,
  `PED_ID` int(11) NOT NULL,
  `PLAE_ID` int(11) NOT NULL,
  `PLAE_CANTIDAD` int(11) NOT NULL,
  CONSTRAINT PK_PLATOESPECIALPEDIDO PRIMARY KEY (`PLAEP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `raciondia`
--

CREATE TABLE `raciondia` (
  `RAC_ID` int(11) AUTO_INCREMENT,
  `MEND_ID` int(11) NOT NULL,
  `RAC_NOMBRE` varchar(100) NOT NULL,
  `RAC_FOTO` longblob DEFAULT NULL,
  `RAC_TIPO` varchar(10) NOT NULL CHECK (`RAC_TIPO` in ('BASE','ENTRADA','PRINCIPIO','CARNE','BEBIDA')),
  `RAC_PRECIO` int(11) NOT NULL,
  CONSTRAINT PK_RACIONDIA PRIMARY KEY (`RAC_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `racionpedido`
--

CREATE TABLE `racionpedido` (
  `RACP_ID` int(11) AUTO_INCREMENT,
  `PED_ID` int(11) NOT NULL,
  `RAC_ID` int(11) NOT NULL,
  `RAC_CANTIDAD` int(11) NOT NULL,
  CONSTRAINT PK_RACIONDIAPEDIDO PRIMARY KEY (`RACP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `restaurante`
--

CREATE TABLE `restaurante` (
  `RES_ID` int(11) AUTO_INCREMENT,
  `CLI_ID` int(11),
  `RES_CODIGO` varchar(5) NOT NULL,
  `RES_NOMBRE` varchar(100) NOT NULL,
  `RES_FOTO` longblob DEFAULT NULL,
  `RES_CARRERA` int(11) NOT NULL,
  `RES_CALLE` int(11) NOT NULL,
  CONSTRAINT PK_RESTAURANTE PRIMARY KEY (`RES_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `menudia`
--
ALTER TABLE `menudia`
  ADD CONSTRAINT `FK_MENUDIA_TIENE_RESTAURA` FOREIGN KEY (`RES_ID`) REFERENCES `restaurante` (`RES_ID`);

--
-- Filtros para la tabla `menuespecial`
--
ALTER TABLE `menuespecial`
  ADD CONSTRAINT `FK_MENUESPE_TIENE2_RESTAURA` FOREIGN KEY (`RES_ID`) REFERENCES `restaurante` (`RES_ID`);

--
-- Filtros para la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `FK_PEDIDO_HACE_CLIENTE` FOREIGN KEY (`CLI_ID`) REFERENCES `cliente` (`CLI_ID`),
  ADD CONSTRAINT `FK_PEDIDO_TIENE7_RESTAURA` FOREIGN KEY (`RES_ID`) REFERENCES `restaurante` (`RES_ID`);
--
-- Filtros para la tabla `platoespecial`
--
ALTER TABLE `platoespecial`
  ADD CONSTRAINT `FK_PLATOESP_TIENE4_MENUESPE` FOREIGN KEY (`MENE_ID`) REFERENCES `menuespecial` (`MENE_ID`);

--
-- Filtros para la tabla `platoespecialpedido`
--
ALTER TABLE `platoespecialpedido`
  ADD CONSTRAINT `FK_PLATOESP_TIENE6_PEDIDO` FOREIGN KEY (`PED_ID`) REFERENCES `pedido` (`PED_ID`),
  ADD CONSTRAINT `FK_PLATOESP_TIENE9_PLATOES` FOREIGN KEY (`PLAE_ID`) REFERENCES `platoespecial` (`PLAE_ID`);

--
-- Filtros para la tabla `raciondia`
--
ALTER TABLE `raciondia`
  ADD CONSTRAINT `FK_RACIONDI_TIENE3_MENUDIA` FOREIGN KEY (`MEND_ID`) REFERENCES `menudia` (`MEND_ID`);

--
-- Filtros para la tabla `cliente`
--
ALTER TABLE `restaurante`
  ADD CONSTRAINT `FK_CLIENTE_TIENE10_RES` FOREIGN KEY (`CLI_ID`) REFERENCES `cliente` (`CLI_ID`);


--
-- Filtros para la tabla `racionpedido`
--
ALTER TABLE `racionpedido`
  ADD CONSTRAINT `FK_RACIONPE_TIENE5_PEDIDO` FOREIGN KEY (`PED_ID`) REFERENCES `pedido` (`PED_ID`),
  ADD CONSTRAINT `FK_RACIONPE_TIENE8_RACIOND` FOREIGN KEY (`RAC_ID`) REFERENCES `raciondia` (`RAC_ID`);
COMMIT;
