CREATE TABLE IF NOT EXISTS public.orders
(
    id bigint NOT NULL,
    created_at timestamp without time zone,
    created_by character varying(255) COLLATE pg_catalog."default",
    modified_at timestamp without time zone,
    modified_by character varying(255) COLLATE pg_catalog."default",
    date_time_ordered timestamp without time zone,
    instructions_to_customer character varying(255) COLLATE pg_catalog."default",
    customer_id bigint,
    inventory_id bigint,
    CONSTRAINT orders_pkey PRIMARY KEY (id),
    CONSTRAINT fk624gtjin3po807j3vix093tlf FOREIGN KEY (customer_id)
        REFERENCES public.customer (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE,
    CONSTRAINT fkpvdkkcqqjg00f2ashjnjceo6v FOREIGN KEY (inventory_id)
        REFERENCES public.inventory (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.orders
    OWNER to muki;

CREATE SEQUENCE orders_sequence START WITH 1 INCREMENT BY 1;
