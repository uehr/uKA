FROM mysql:8.0
EXPOSE 3306

ENV MYSQL_DATABASE uka
ENV MYSQL_USER user
ENV MYSQL_PASSWORD password
ENV MYSQL_ROOT_PASSWORD rootpassword

COPY mysql-conf /etc/mysql/conf.d
RUN mkdir /var/lib/mysql-files
RUN chown -R mysql:mysql /var/lib/mysql-files/
RUN chmod 700 /var/lib/mysql-files/