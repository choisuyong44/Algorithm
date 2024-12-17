SELECT HALF.flavor
FROM FIRST_HALF HALF
INNER JOIN ICECREAM_INFO INFO ON HALF.flavor = INFO.flavor
WHERE HALF.total_order > 3000 AND INFO.ingredient_type = 'fruit_based'
ORDER BY total_order DESC;