CREATE TABLE POSTS_ORIGINS
(
    POST_ID   INTEGER
        CONSTRAINT POSTS_ORIGINS_POST_ID_FKEY
            REFERENCES POSTS,
    ORIGIN_ID INTEGER
        CONSTRAINT POSTS_ORIGINS_ORIGIN_ID_FKEY
            REFERENCES ORIGINS
);

ALTER TABLE POSTS_ORIGINS
    OWNER TO POSTGRES;


