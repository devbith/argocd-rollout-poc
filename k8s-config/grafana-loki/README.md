## Install granfana loki with helm

### Install helm

> https://helm.sh/docs/intro/install/


## Add Grafna to HELM chart repository

```
helm repo add grafana https://grafana.github.io/helm-charts
```


```
helm install --values values.yml loki grafana/loki-stack -n loki-stack --set grafana.enabled=true --create-namespace
```

Start using with port forwarding
```
kubectl port-forward svc/loki-grafana -n loki-stack 3000:80

```


Extract the password

```
kubectl get secrets -n loki-stack loki-grafana -o jsonpath="{.data.admin-password}" | base64 --decode

```
