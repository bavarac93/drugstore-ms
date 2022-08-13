CREATE TABLE IF NOT EXISTS public.facility
(
    id bigint NOT NULL,
    created_at timestamp without time zone,
    created_by character varying(255) COLLATE pg_catalog."default",
    modified_at timestamp without time zone,
    modified_by character varying(255) COLLATE pg_catalog."default",
    date_opened date,
    email character varying(255) COLLATE pg_catalog."default",
    facility_name character varying(255) COLLATE pg_catalog."default",
    phone_number character varying(255) COLLATE pg_catalog."default",
    website character varying(255) COLLATE pg_catalog."default",
    address_id bigint,
    inventory_id bigint,
    orders_id bigint,
    CONSTRAINT facility_pkey PRIMARY KEY (id),
    CONSTRAINT fk1yyamb7slp0ml2vxxd2r8uec0 FOREIGN KEY (inventory_id)
        REFERENCES public.inventory (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkbpfxetgowgub5rnee0iy0nd4c FOREIGN KEY (address_id)
        REFERENCES public.address (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkn4qd6anp5hfw8f3m7c0vci148 FOREIGN KEY (orders_id)
        REFERENCES public.orders (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.facility
    OWNER to postgres;

CREATE SEQUENCE facility_sequence START WITH 1 INCREMENT BY 1;
