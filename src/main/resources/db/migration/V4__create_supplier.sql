CREATE TABLE IF NOT EXISTS public.supplier
(
    id bigint NOT NULL,
    created_at timestamp without time zone,
    created_by character varying(255) COLLATE pg_catalog."default",
    modified_at timestamp without time zone,
    modified_by character varying(255) COLLATE pg_catalog."default",
    contract_expires date,
    contract_signed date,
    supplier_desc character varying(255) COLLATE pg_catalog."default",
    supplier_name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT supplier_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.supplier
    OWNER to postgres;

CREATE SEQUENCE supplier_sequence START WITH 1 INCREMENT BY 1;
