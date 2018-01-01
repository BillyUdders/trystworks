CREATE KEYSPACE user
WITH REPLICATION = {'class':'NetworkTopologyStrategy', 'datacenter1':3}