# Kubernetes

## What is K8s?

- Kubernetes is an open source container orchestration tool
- Developed by Google
- Helps to manage containerized applications in different deployment environments

## Why K8s?

- There was a need for a container orchestration tool
- Increasing trend from monolith to microservices
- Increased usage of containers
- Demand for a proper way for managing these containers


## Benefits

- High availability
- Scalability
- Disaster Recovery: Backup and Restore
- Every component is replicated and load balanced reducing bottlenecks
- Disaster Recovery: Cluster administrator managed snapshots of etcd outisde of the cluster.

## Architecture


### Nodes

* There are three processes which must run on every node: Container Runtime, Kubelet, Kube Proxy
* Each node has multiple pods on it
* To add a new node, get new bare server, install all the node processes and add it to the cluster.

#### Container Runtime

* The application which runs the container, for example, Docker.

#### Kubelet

* Kubelet interacts with both the container and the node and starts the pod with a container running inside it.
* Kubelet makes it possible for cluster to talk to each other and execute some process on the nodes.

#### Kube Proxy

* Responsible for forwarding requests from services to pods
* Consists of intelligent forwarding logic inside which makes sure communication works in a performant way like sending the requests to a pod replica runnng in the same node and not any other node avoiding the network overhead.

### Master Node

* One Master Node with Several Worker Node connected to it
* Master node runs several kubernetes processes necessary to run and manage the cluster properly.
* Each work node has docker containers of different applications deployed on it. The actual work happens here.
* Worker nodes are much bigger and have more resources while Master node runs a handful of resources.
* Having of a backup of the master is a must. Keeping at least two master nodes is a must.

#### API Server

- A cluster gateway which gets the initial request of any updates into the cluster. 
- Different kuberetnes clients talk to it.
- Acts as gatekeeper for authenticator

#### Scheduler

* Decides on which node the next container should be scheduled on based on availbility of server resources.
* Intelligently decides which node a new pod should be assigned to and tells the kubelet to recreate a pod

#### Controller Manager

* Detect state changes
* Makes request to scheduler
* Keeps track of what is happening in the cluster: repairs, container death, restart required, etc.

#### ETCD

* The etcd is a distributed key value storage stores the entire configuration of the kubernetes cluster. We can restore the entire cluster state using the etcd snapshot. 

#### Virtual Network 

* Turns all the nodes inside the cluster into one powerful machine that has sum of all the resources of the individual nodes.

### Pods

* Pod is an abstraction over a container and is the smallest unit which can be configured and interacted with.
* Each worker node has multiple pods and each pod can run multiple container.
* Usually one has one pod per application
* The virtual network assigns each pod an IP address which is utilised by the pods to talk to each other.
* If a container dies inside a pod, it is automatically restarted.

### Service

* Services catches request directed to the pod and forwards it to the respective pod.
* Service has a permanent/static IP address used to communicate between pods and a load balancer: app pod can communicate with the database pod.
* If a pod is restarted or recreated, it gets a new IP address. This is a problem. So instead we have services sitting in front of each pod.
* We don't need to change the endpoint anymore.

#### Internal vs External Service

* External service is a service which opens the communication form external sources such as web browsers.
* We use an internal service which does not open our database to the outside world.

### Ingress

* Since the external service IP address is not useable, we use *ingress* which consumes the initial request and does the forwarding of the request to the service.
* Ingress components are their own pods on the servers and thus can be replicated.
* It handles every incoming component and since it is load balanced, it re routes the traffic to the appropriate pods.

### ConfigMap

* ConfigMap contains external configuration of your application this avoids rebuilding the image if some configuration data has changed.

### Secret

* Similar to ConfigMap used to store base64 encoded secret data and credentials which others should not have access to..

### Volumes

* Volume attaches a physical or remote storage to a pod so that when a pod goes down and is restarted we have the data saved in the volume.
* This is needed because K8s doesn't handle data persistence.


### Deployment

* If a pod dies, there is a downtime and users are unhappy. This is why we have replicas of our pods in another node which is also connected to the same services as the previous pod.
* The number of replicas is defined in the blueprint / configurations for application's pod

### StatefulSet

* Database cannot be replicated using deployment becuase databases have a state which needs to be managed.
* StatefulSet is a component of Kubernetes which takes care of replicating pods making sure the operations are synchronized.
* It is sometimes preferable to have databases hosted outside the Kubernetes cluster.

## Configuration YAML

```yaml
apivERsion: app/v1
name: my-awesome-app
labels:
  app: my-awesome-app
spec:
  repolicas: 3
  selector:
    matchLabels:
      app: my-awesome-app
  template:
    metadata:
      labels:
        app: my-awesome-app
  spec:
    containers:
      - name: my-awesome-app
        image: my-image
        env:
          - name: PORT
            value: 8081
          - containerPort: 8080
```

## Namespace

- Organise resoures in a namespace
- Namespace is a virtual cluster inside a kubernetes cluster

### Defaults

- kubernetes-dashboard only speicifc for minikube
- kube-system: Do NOT create or modify anything here. Used for system. master and kubectl processes.
- kube-public: puclically accessible data, consists of a config map wiith cluster information
- kube-node-lease: holds information about the heartbeats of a node, each node has an associated lease object, determines the availbility of the node
- default-namespace: resources created are located here.

### Usage

- Instead of having all components in one namespace, we can separate them into different namespaces depending on the services and usage
- Example: DB, Monitoring, Elastic Stack, Nginx-Ingress
- Avoids conflicts in case of many teams working on the same application.
- Staging and Development can share resources like Nginx-Controller and Elastic Stack
- Blue-Green Deployment: Having different version of production in the sae environment.
- Access and Resource Limits on namespaces
- Volumes and Nodes cannot be created within a namespace as they live globally in a cluster.


## Minikube

- Minikube is an open source tool allowing you to run production setup on your local machine. It is a one node cluster with the master and workder procceses running on one node with Docker preinstalled.
- One node kubernetes cluster for testing purpose
- Creates a virtual box on your system
- Node runs in that virtual box

### Kubectl

- Kubectl is a Command-line tool for k8 cluster which allows you to talk to the cluster's API server.

