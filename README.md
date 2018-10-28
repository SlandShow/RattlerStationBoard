# 🚆  Rattler Station Board app  🚆
### `Showing schedule for today, dynamic update schedulers via AJAX`

### Used:

1. Maven
2. WildFly 14 (JBoss)
3. EJB
4. JSF 2.0 & PrimeFace's
5. RabbitMQ broker

## Configuration 🔨

### WildFly 💻

1. [Install JBoss server](http://wildfly.org/downloads "WildFly")
2. Config `standalone.xm` file: Change default port `8080` on `8181`, because `8080` port already on Tomcat.
3. Add JMS configuration in `standalone.xml`.

### RabbitMQ broker 📬

1. [Install RabbitMQ broker on Ubuntu guide](https://www.vultr.com/docs/how-to-install-rabbitmq-on-ubuntu-16-04-47 "RabbitMQ")
2. Install `Erland`.
3. Install `RabbitMq server`.
4. Config `RabitMQ server`.
5. Add admin user.
6. Open in browser `http://localhost:15672`.

### Links

🚉 [RattlerStation](https://github.com/SlandShow/RattlerStation "RattlerStation") → main app.

