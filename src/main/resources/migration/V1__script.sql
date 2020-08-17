--
-- PostgreSQL database dump
--

-- Dumped from database version 11.5
-- Dumped by pg_dump version 11.5

-- Started on 2020-08-17 19:03:33

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
-- TOC entry 598 (class 1247 OID 34072)
-- Name: employee_type; Type: TYPE; Schema: public; Owner: postgres
--

CREATE TYPE public.employee_type AS ENUM (
    'doctor',
    'nurse',
    'surgeon',
    'therapist'
);


ALTER TYPE public.employee_type OWNER TO postgres;

--
-- TOC entry 604 (class 1247 OID 34087)
-- Name: room_type_name; Type: TYPE; Schema: public; Owner: postgres
--

CREATE TYPE public.room_type_name AS ENUM (
    'Treatment room',
    'Intensive care room',
    'Reception room'
);


ALTER TYPE public.room_type_name OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 196 (class 1259 OID 34081)
-- Name: employee; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employee (
    id integer NOT NULL,
    first_name character(50) NOT NULL,
    last_name character(60) NOT NULL,
    type public.employee_type NOT NULL
);


ALTER TABLE public.employee OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 34136)
-- Name: employee_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.employee_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.employee_id_seq OWNER TO postgres;

--
-- TOC entry 2870 (class 0 OID 0)
-- Dependencies: 200
-- Name: employee_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.employee_id_seq OWNED BY public.employee.id;


--
-- TOC entry 204 (class 1259 OID 34151)
-- Name: reservation; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.reservation (
    id integer NOT NULL,
    date_in timestamp without time zone NOT NULL,
    date_out timestamp without time zone NOT NULL,
    employee_id integer NOT NULL,
    reservation_reason_id integer NOT NULL,
    room_id integer NOT NULL
);


ALTER TABLE public.reservation OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 34164)
-- Name: reservation_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.reservation_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.reservation_id_seq OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 34108)
-- Name: reservation_reason; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.reservation_reason (
    id integer NOT NULL,
    name character(60) NOT NULL,
    description character(1000)
);


ALTER TABLE public.reservation_reason OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 34142)
-- Name: reservation_reason_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.reservation_reason_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.reservation_reason_id_seq OWNER TO postgres;

--
-- TOC entry 2871 (class 0 OID 0)
-- Dependencies: 201
-- Name: reservation_reason_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.reservation_reason_id_seq OWNED BY public.reservation_reason.id;


--
-- TOC entry 198 (class 1259 OID 34098)
-- Name: room; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.room (
    id integer NOT NULL,
    number integer NOT NULL,
    room_type_id integer NOT NULL
);


ALTER TABLE public.room OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 34145)
-- Name: room_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.room_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.room_id_seq OWNER TO postgres;

--
-- TOC entry 2872 (class 0 OID 0)
-- Dependencies: 202
-- Name: room_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.room_id_seq OWNED BY public.room.id;


--
-- TOC entry 197 (class 1259 OID 34093)
-- Name: room_type; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.room_type (
    id integer NOT NULL,
    name public.room_type_name NOT NULL
);


ALTER TABLE public.room_type OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 34148)
-- Name: room_type_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.room_type_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.room_type_id_seq OWNER TO postgres;

--
-- TOC entry 2873 (class 0 OID 0)
-- Dependencies: 203
-- Name: room_type_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.room_type_id_seq OWNED BY public.room_type.id;


--
-- TOC entry 2716 (class 2604 OID 34138)
-- Name: employee id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee ALTER COLUMN id SET DEFAULT nextval('public.employee_id_seq'::regclass);


--
-- TOC entry 2719 (class 2604 OID 34144)
-- Name: reservation_reason id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservation_reason ALTER COLUMN id SET DEFAULT nextval('public.reservation_reason_id_seq'::regclass);


--
-- TOC entry 2718 (class 2604 OID 34147)
-- Name: room id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.room ALTER COLUMN id SET DEFAULT nextval('public.room_id_seq'::regclass);


--
-- TOC entry 2717 (class 2604 OID 34150)
-- Name: room_type id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.room_type ALTER COLUMN id SET DEFAULT nextval('public.room_type_id_seq'::regclass);


--
-- TOC entry 2855 (class 0 OID 34081)
-- Dependencies: 196
-- Data for Name: employee; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.employee (id, first_name, last_name, type) VALUES (1, 'first                                             ', 'last                                                        ', 'doctor');
INSERT INTO public.employee (id, first_name, last_name, type) VALUES (4, 'firstNameRef.current.value                        ', 'lastNameRef.current.value                                   ', 'doctor');
INSERT INTO public.employee (id, first_name, last_name, type) VALUES (5, 'first                                             ', 'Last                                                        ', 'doctor');
INSERT INTO public.employee (id, first_name, last_name, type) VALUES (6, 'fd                                                ', 'df                                                          ', 'doctor');


--
-- TOC entry 2863 (class 0 OID 34151)
-- Dependencies: 204
-- Data for Name: reservation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.reservation (id, date_in, date_out, employee_id, reservation_reason_id, room_id) VALUES (1, '2020-08-14 20:00:00', '2020-08-14 21:00:00', 1, 2, 3);
INSERT INTO public.reservation (id, date_in, date_out, employee_id, reservation_reason_id, room_id) VALUES (5, '2020-08-15 20:00:00', '2020-08-15 21:00:00', 1, 2, 3);
INSERT INTO public.reservation (id, date_in, date_out, employee_id, reservation_reason_id, room_id) VALUES (6, '2020-08-15 14:40:00', '2020-08-15 15:04:09.856886', 1, 2, 3);
INSERT INTO public.reservation (id, date_in, date_out, employee_id, reservation_reason_id, room_id) VALUES (7, '2020-08-17 15:10:00', '2020-08-17 15:40:00', 1, 2, 4);
INSERT INTO public.reservation (id, date_in, date_out, employee_id, reservation_reason_id, room_id) VALUES (8, '2020-08-17 15:10:00', '2020-08-17 15:40:00', 1, 3, 5);
INSERT INTO public.reservation (id, date_in, date_out, employee_id, reservation_reason_id, room_id) VALUES (9, '2020-08-17 15:10:00', '2020-08-17 15:40:00', 1, 3, 5);
INSERT INTO public.reservation (id, date_in, date_out, employee_id, reservation_reason_id, room_id) VALUES (10, '2020-08-17 15:10:00', '2020-08-17 15:40:00', 1, 3, 5);
INSERT INTO public.reservation (id, date_in, date_out, employee_id, reservation_reason_id, room_id) VALUES (11, '2020-08-17 15:10:00', '2020-08-17 15:40:00', 1, 3, 5);
INSERT INTO public.reservation (id, date_in, date_out, employee_id, reservation_reason_id, room_id) VALUES (13, '2020-08-17 15:10:00', '2020-08-17 15:40:00', 1, 4, 6);
INSERT INTO public.reservation (id, date_in, date_out, employee_id, reservation_reason_id, room_id) VALUES (14, '2020-08-17 16:10:00', '2020-08-17 17:50:00', 1, 4, 6);
INSERT INTO public.reservation (id, date_in, date_out, employee_id, reservation_reason_id, room_id) VALUES (16, '2020-08-17 16:10:00', '2020-08-17 17:50:00', 1, 4, 3);
INSERT INTO public.reservation (id, date_in, date_out, employee_id, reservation_reason_id, room_id) VALUES (17, '2020-08-17 18:02:00', '2020-08-17 19:02:00', 5, 5, 3);
INSERT INTO public.reservation (id, date_in, date_out, employee_id, reservation_reason_id, room_id) VALUES (19, '2020-08-17 19:08:00', '2020-08-17 20:08:00', 5, 7, 4);
INSERT INTO public.reservation (id, date_in, date_out, employee_id, reservation_reason_id, room_id) VALUES (18, '2020-08-17 18:05:00', '2020-08-17 18:58:02.788383', 5, 6, 4);


--
-- TOC entry 2858 (class 0 OID 34108)
-- Dependencies: 199
-- Data for Name: reservation_reason; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.reservation_reason (id, name, description) VALUES (2, 'Therapy                                                     ', NULL);
INSERT INTO public.reservation_reason (id, name, description) VALUES (3, 'Therapyy                                                    ', NULL);
INSERT INTO public.reservation_reason (id, name, description) VALUES (4, 'Test                                                        ', NULL);
INSERT INTO public.reservation_reason (id, name, description) VALUES (5, 'fgsdf                                                       ', '                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        ');
INSERT INTO public.reservation_reason (id, name, description) VALUES (6, 'fsdfds                                                      ', '                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        ');
INSERT INTO public.reservation_reason (id, name, description) VALUES (7, 'sfdaasdas                                                   ', '                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        ');


--
-- TOC entry 2857 (class 0 OID 34098)
-- Dependencies: 198
-- Data for Name: room; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.room (id, number, room_type_id) VALUES (3, 100, 2);
INSERT INTO public.room (id, number, room_type_id) VALUES (4, 101, 3);
INSERT INTO public.room (id, number, room_type_id) VALUES (5, 102, 4);
INSERT INTO public.room (id, number, room_type_id) VALUES (6, 103, 5);
INSERT INTO public.room (id, number, room_type_id) VALUES (7, 104, 6);
INSERT INTO public.room (id, number, room_type_id) VALUES (8, 105, 7);
INSERT INTO public.room (id, number, room_type_id) VALUES (9, 106, 8);
INSERT INTO public.room (id, number, room_type_id) VALUES (10, 200, 9);


--
-- TOC entry 2856 (class 0 OID 34093)
-- Dependencies: 197
-- Data for Name: room_type; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.room_type (id, name) VALUES (2, 'Treatment room');
INSERT INTO public.room_type (id, name) VALUES (3, 'Treatment room');
INSERT INTO public.room_type (id, name) VALUES (4, 'Treatment room');
INSERT INTO public.room_type (id, name) VALUES (5, 'Intensive care room');
INSERT INTO public.room_type (id, name) VALUES (6, 'Intensive care room');
INSERT INTO public.room_type (id, name) VALUES (7, 'Reception room');
INSERT INTO public.room_type (id, name) VALUES (8, 'Reception room');
INSERT INTO public.room_type (id, name) VALUES (9, 'Intensive care room');


--
-- TOC entry 2874 (class 0 OID 0)
-- Dependencies: 200
-- Name: employee_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.employee_id_seq', 6, true);


--
-- TOC entry 2875 (class 0 OID 0)
-- Dependencies: 205
-- Name: reservation_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.reservation_id_seq', 19, true);


--
-- TOC entry 2876 (class 0 OID 0)
-- Dependencies: 201
-- Name: reservation_reason_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.reservation_reason_id_seq', 7, true);


--
-- TOC entry 2877 (class 0 OID 0)
-- Dependencies: 202
-- Name: room_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.room_id_seq', 10, true);


--
-- TOC entry 2878 (class 0 OID 0)
-- Dependencies: 203
-- Name: room_type_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.room_type_id_seq', 9, true);


--
-- TOC entry 2721 (class 2606 OID 34085)
-- Name: employee employee_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee
    ADD CONSTRAINT employee_pkey PRIMARY KEY (id);


--
-- TOC entry 2729 (class 2606 OID 34155)
-- Name: reservation reservation_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservation
    ADD CONSTRAINT reservation_pkey PRIMARY KEY (id);


--
-- TOC entry 2727 (class 2606 OID 34115)
-- Name: reservation_reason reservation_reason_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservation_reason
    ADD CONSTRAINT reservation_reason_pkey PRIMARY KEY (id);


--
-- TOC entry 2725 (class 2606 OID 34102)
-- Name: room room_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.room
    ADD CONSTRAINT room_pkey PRIMARY KEY (id);


--
-- TOC entry 2723 (class 2606 OID 34097)
-- Name: room_type room_type_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.room_type
    ADD CONSTRAINT room_type_pkey PRIMARY KEY (id);


--
-- TOC entry 2732 (class 2606 OID 34176)
-- Name: reservation fkm8xumi0g23038cw32oiva2ymw; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservation
    ADD CONSTRAINT fkm8xumi0g23038cw32oiva2ymw FOREIGN KEY (room_id) REFERENCES public.room(id);


--
-- TOC entry 2731 (class 2606 OID 34166)
-- Name: reservation fkoq2iacdgt8val8v26jn0iw83q; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservation
    ADD CONSTRAINT fkoq2iacdgt8val8v26jn0iw83q FOREIGN KEY (employee_id) REFERENCES public.employee(id);


--
-- TOC entry 2733 (class 2606 OID 34189)
-- Name: reservation reservation_reservation_reason_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservation
    ADD CONSTRAINT reservation_reservation_reason_id_fkey FOREIGN KEY (reservation_reason_id) REFERENCES public.reservation_reason(id);


--
-- TOC entry 2730 (class 2606 OID 34103)
-- Name: room room_type_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.room
    ADD CONSTRAINT room_type_id FOREIGN KEY (room_type_id) REFERENCES public.room_type(id);


-- Completed on 2020-08-17 19:03:34

--
-- PostgreSQL database dump complete
--

