CREATE TABLE public.historie (
    id uuid NOT NULL,
    mesto text NOT NULL,
    datum date NOT NULL,
    teplota DOUBLE PRECISION NOT NULL,
    PRIMARY KEY(id)
);