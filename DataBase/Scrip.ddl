CREATE TABLE ciudad (
    codigo              INTEGER NOT NULL,
    descripcion         VARCHAR(100) NOT NULL,
    departamento_codigo INTEGER NOT NULL
);

ALTER TABLE ciudad ADD CONSTRAINT ciudad_pk PRIMARY KEY ( codigo );

CREATE TABLE departamento (
    codigo      INTEGER NOT NULL,
    descripcion VARCHAR(100) NOT NULL,
    pais        INTEGER NOT NULL
);

ALTER TABLE departamento ADD CONSTRAINT departamento_pk PRIMARY KEY ( codigo );

CREATE TABLE estadopedido (
    codigo         INTEGER NOT NULL,
    descripcion    VARCHAR(100) NOT NULL,
    novedad_codigo INTEGER NOT NULL,
    pedido_codigo  INTEGER NOT NULL
);

CREATE UNIQUE INDEX estadopedido__idx ON
    estadopedido (
        novedad_codigo
    ASC );

CREATE UNIQUE INDEX estadopedido__idxv1 ON
    estadopedido (
        pedido_codigo
    ASC );

ALTER TABLE estadopedido ADD CONSTRAINT estadopedido_pk PRIMARY KEY ( codigo );

CREATE TABLE historialpedido (
    codigo    INTEGER NOT NULL,
    fecha     DATE NOT NULL,
    vendedor  INTEGER NOT NULL,
    comprador INTEGER NOT NULL
);

ALTER TABLE historialpedido ADD CONSTRAINT historialpedido_pk PRIMARY KEY ( codigo );

CREATE TABLE novedad (
    codigo         INTEGER NOT NULL,
    descripcion    VARCHAR(100) NOT NULL,
    persona_codigo INTEGER NOT NULL
);

ALTER TABLE novedad ADD CONSTRAINT novedad_pk PRIMARY KEY ( codigo );

CREATE TABLE pais (
    codigo      INTEGER NOT NULL,
    descripcion VARCHAR(100) NOT NULL
);

ALTER TABLE pais ADD CONSTRAINT pais_pk PRIMARY KEY ( codigo );

CREATE TABLE pedido (
    codigo      INTEGER NOT NULL,
    descripcion VARCHAR(200) NOT NULL,
    cantidad    INTEGER NOT NULL,
    fecha       DATE NOT NULL,
    comprador   INTEGER NOT NULL,
    historial   INTEGER NOT NULL,
    publicacion INTEGER NOT NULL
);

ALTER TABLE pedido ADD CONSTRAINT pedido_pk PRIMARY KEY ( codigo );

CREATE TABLE persona (
    codigo                    INTEGER NOT NULL,
    identificacion            INTEGER NOT NULL,
    nombres                   VARCHAR(100) NOT NULL,
    apellidos                 VARCHAR(100) NOT NULL,
    fechanacimiento           DATE,
    tipoidentificacion_codigo INTEGER NOT NULL,
    ciudad_codigo             INTEGER NOT NULL
);

ALTER TABLE persona ADD CONSTRAINT persona_pk PRIMARY KEY ( codigo );

CREATE TABLE producto (
    codigo             INTEGER NOT NULL,
    nombre             VARCHAR(50) NOT NULL,
    descripcion        VARCHAR(200) NOT NULL,
    tipoproducto       INTEGER NOT NULL,
    publicacion_codigo INTEGER NOT NULL,
    pedido_codigo      INTEGER NOT NULL,
    imagen             VARCHAR(100)
);

CREATE UNIQUE INDEX producto__idx ON
    producto (
        publicacion_codigo
    ASC );

CREATE UNIQUE INDEX producto__idxv1v1 ON
    producto (
        pedido_codigo
    ASC );

ALTER TABLE producto ADD CONSTRAINT producto_pk PRIMARY KEY ( codigo );

CREATE TABLE publicacion (
    codigo      INTEGER NOT NULL,
    descripcion VARCHAR(200) NOT NULL,
    precio      INTEGER NOT NULL,
    cantidad    INTEGER NOT NULL,
    vendedor    INTEGER NOT NULL,
    tipoventa   INTEGER NOT NULL
);

ALTER TABLE publicacion ADD CONSTRAINT publicacion_pk PRIMARY KEY ( codigo );

CREATE TABLE tipoidentificacion (
    codigo      INTEGER NOT NULL,
    descripcion VARCHAR(100) NOT NULL
);

ALTER TABLE tipoidentificacion ADD CONSTRAINT tipoidentificacion_pk PRIMARY KEY ( codigo );

CREATE TABLE tipoproducto (
    codigo     INTEGER NOT NULL,
    decripcion VARCHAR(100) NOT NULL
);

ALTER TABLE tipoproducto ADD CONSTRAINT tipoproducto_pk PRIMARY KEY ( codigo );

CREATE TABLE tipoventa (
    codigo      INTEGER NOT NULL,
    descripcion VARCHAR(100) NOT NULL
);

ALTER TABLE tipoventa ADD CONSTRAINT tipoventa_pk PRIMARY KEY ( codigo );

ALTER TABLE ciudad
    ADD CONSTRAINT ciudad_departamento_fk FOREIGN KEY ( departamento_codigo )
        REFERENCES departamento ( codigo );

ALTER TABLE departamento
    ADD CONSTRAINT departamento_pais_fk FOREIGN KEY ( pais )
        REFERENCES pais ( codigo );

ALTER TABLE estadopedido
    ADD CONSTRAINT estadopedido_novedad_fk FOREIGN KEY ( novedad_codigo )
        REFERENCES novedad ( codigo );

ALTER TABLE estadopedido
    ADD CONSTRAINT estadopedido_pedido_fk FOREIGN KEY ( pedido_codigo )
        REFERENCES pedido ( codigo );

ALTER TABLE historialpedido
    ADD CONSTRAINT historialpedido_persona_fk FOREIGN KEY ( vendedor )
        REFERENCES persona ( codigo );

ALTER TABLE historialpedido
    ADD CONSTRAINT historialpedido_persona_fkv2 FOREIGN KEY ( comprador )
        REFERENCES persona ( codigo );

ALTER TABLE novedad
    ADD CONSTRAINT novedad_persona_fk FOREIGN KEY ( persona_codigo )
        REFERENCES persona ( codigo );

ALTER TABLE pedido
    ADD CONSTRAINT pedido_historialpedido_fk FOREIGN KEY ( historial )
        REFERENCES historialpedido ( codigo );

ALTER TABLE pedido
    ADD CONSTRAINT pedido_persona_fk FOREIGN KEY ( comprador )
        REFERENCES persona ( codigo );

ALTER TABLE pedido
    ADD CONSTRAINT pedido_publicacion_fk FOREIGN KEY ( publicacion )
        REFERENCES publicacion ( codigo );

ALTER TABLE persona
    ADD CONSTRAINT persona_ciudad_fk FOREIGN KEY ( ciudad_codigo )
        REFERENCES ciudad ( codigo );

ALTER TABLE persona
    ADD CONSTRAINT persona_tipoidentificacion_fk FOREIGN KEY ( tipoidentificacion_codigo )
        REFERENCES tipoidentificacion ( codigo );

ALTER TABLE producto
    ADD CONSTRAINT producto_pedido_fk FOREIGN KEY ( pedido_codigo )
        REFERENCES pedido ( codigo );

ALTER TABLE producto
    ADD CONSTRAINT producto_publicacion_fk FOREIGN KEY ( publicacion_codigo )
        REFERENCES publicacion ( codigo );

ALTER TABLE producto
    ADD CONSTRAINT producto_tipoproducto_fk FOREIGN KEY ( tipoproducto )
        REFERENCES tipoproducto ( codigo );

ALTER TABLE publicacion
    ADD CONSTRAINT publicacion_persona_fk FOREIGN KEY ( vendedor )
        REFERENCES persona ( codigo );

ALTER TABLE publicacion
    ADD CONSTRAINT publicacion_tipoventa_fk FOREIGN KEY ( tipoventa )
        REFERENCES tipoventa ( codigo );