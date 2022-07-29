--
-- PostgreSQL database dump
--

-- Dumped from database version 14.4 (Debian 14.4-1.pgdg110+1)
-- Dumped by pg_dump version 14.4 (Debian 14.4-1.pgdg110+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: springboot
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO springboot;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: sondas; Type: TABLE; Schema: public; Owner: springboot
--

CREATE TABLE public.sondas (
    id bigint NOT NULL,
    name character varying(255),
    posicao character varying(255),
    x integer NOT NULL,
    y integer NOT NULL
);


ALTER TABLE public.sondas OWNER TO springboot;


--
-- Data for Name: sondas; Type: TABLE DATA; Schema: public; Owner: springboot
--

COPY public.sondas (id, name, posicao, x, y) FROM stdin;
1	sonda1	N	1	2
2	sonda2	E	3	3
\.


--
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: springboot
--

SELECT pg_catalog.setval('public.hibernate_sequence', 3, true);


--
-- Name: sondas sondas_pkey; Type: CONSTRAINT; Schema: public; Owner: springboot
--

ALTER TABLE ONLY public.sondas
    ADD CONSTRAINT sondas_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

