##################################

#####        Kafka         #####          

##################################



---------Entrar no Container------------------
sudo docker exec -it orange-talents-07-template-proposta_kafka_1 /bin/bash



-------------Executar Comando Kafka Dentro do terminal--------------



------Criar Tópico
usr/bin/kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic LOJA_NOVO_PEDIDO


---Deletar topicos
usr/bin/kafka-topics --delete --bootstrap-server localhost:9092 --topic your_topic_name

------Listar Tópicos
usr/bin/kafka-topics --list --bootstrap-server localhost:9092

------Consumir Mensagem topicos

---Consome novas mensagens
usr/bin/kafka-console-consumer --bootstrap-server localhost:9092 --topic LOJA_NOVO_PEDIDO

---Consome mensagens des do inicio

usr/bin/kafka-console-consumer --bootstrap-server localhost:9092 --topic LOJA_NOVO_PEDIDO --from-beginer

---Descrição do topico

usr/bin/kafka-topics --bootstrap-server localhost:9092 --describe

-----------Para mudar o numero de partições para novos tópicos
vi cinfig/server.properties

-------Alterar u número de partições de um tópico existente

usr/bin/kafka-topics --alter --zookeeper zookeeper:2181 LOJA_NOVO_PEDIDO --partitions 3

-----Para verificar um grupo de consumo

usr/bin/kafka-consumer-groups --al-groups --bootstrap-server localhost:9092 --describe













