## Instructions To Setup Kubernetes Tools

#### Install prometheus-operator

- `kubectl apply -f prometheus-operator/namespace.yaml`
- `kubectl apply --server-side -f prometheus-operator/crds`
- `kubectl apply -f prometheus-operator/rbac`
- `kubectl apply -f prometheus-operator/deployment`

     *Verify:* Pod `prometheus-operator-` should be up and running: `kubectl get -n monitoring pods` 


#### Install prometheus
- `kubectl apply -f prometheus`

   *Verify:* Pod `prometheus-main` should be up and running: `kubectl get -n monitoring pods` 

- `kubectl port-forward -n monitoring svc/prometheus-operated 9090:9090`

#### Install argocd
- `kubectl apply -f argocd/0-namespace.yaml` 
- `kubectl apply -f argocd/1-install.yaml`
- Start minikube tunneling
   
    `minikube tunnel`

- Change the argocd-server service type to LoadBalancer:

    `kubectl patch svc argocd-server -n argocd -p '{"spec": {"type": "LoadBalancer"}}'`

    `kubectl port-forward svc/argocd-server -n argocd 8080:443` 

- Command to reterieve argocd password:
 
  `kubectl -n argocd get secret argocd-initial-admin-secret -o jsonpath="{.data.password}" | base64 -d`

#### Install argo-rollout
- `kubectl apply -f argo-rollout/0-namespace.yaml`
- `kubectl apply -f argo-rollout/1-install.yaml -n argo-rollouts`

### Install greet-app 
- `kubectl apply -f greet-app`
- `kubectl argo rollouts get rollout my-greet-app --watch -n localdevelopment`

### Expose the prometheus as NodePort 

- `kubectl expose service -n monitoring prometheus-operated --type=NodePort --target-port=9090 --name=prometheus-server-np`
- Get the cluster IP of expose NodePort `prometheus-server-np` with the command `kubectl get svc -n monitoring` 
- Edit the file `greet-app/2-deployment-analysis-template.yaml` and replace the IP with collected above
