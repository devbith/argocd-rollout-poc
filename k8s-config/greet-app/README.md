### Expose prometheus as NodePort and get the cluster ip and upate the ip in 2-deployment-analysis-template.yaml
`kubectl expose service -n monitoring prometheus-operated --type=NodePort --target-port=9090 --name=prometheus-server-np`
