FROM mysql:8.0
EXPOSE 3306

COPY mysql-conf /etc/mysql/conf.d
RUN mkdir /var/lib/mysql-files
RUN chown -R mysql:mysql /var/lib/mysql-files/
RUN chmod 700 /var/lib/mysql-files/