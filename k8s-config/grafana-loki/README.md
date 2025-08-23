## Install granfana loki with helm

```
helm install --values values.yml loki grafana/loki-stack -n loki-stack --set grafana.enabled=true --create-namespace
```

Start using with port forwarding
```
kubectl port-forward -n loki-stack pods/loki-grafana-f6d59ccdb-k698w 3000:3000
```


Extract the password

```
kubectl get secrets -n loki-stack loki-grafana -o jsonpath="{.data.admin-password}" | base64 --decode

```
