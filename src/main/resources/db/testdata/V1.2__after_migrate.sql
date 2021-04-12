UPDATE DOCTORS D
SET PUBLISHED_POSTS=(
    SELECT COUNT(P.POST_ID)
    FROM POSTS P
    WHERE P.AUTHOR_ID=D.USER_ID
      AND STATUS='PUBLISHED'
);

UPDATE DOCTORS SET RATING=PUBLISHED_POSTS * PROMOTION_SCALE;