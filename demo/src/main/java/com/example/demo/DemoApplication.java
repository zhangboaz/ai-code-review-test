package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        /* 迪杰斯特拉（Dijkstra) 算法*/
        void ShortestPath_Dijkstra(MGraph G, int v0, Patharc path, ShortPathTable dist)
        {
            int v, w, k, min;
            int final[MaxVerterNum];				// final[w] = 1表示求得顶点 v0 至 vw的最短路径，即已访问过顶点vw
            for (v = 0; v < G.vexNum; v++)
            {
                final[v] = 0;						// 全部顶点初始化为未知最短路径状态
                dist[v] = G.Edge[v0][v];			// 将与v0点有连线的顶点加上权值
                path[v] = -1;						// 初始化路劲数组p为-1
            }
            dist[v0] = 0;							// v0至v0路径为0
            final[v0] = 1;							// v0至v0不需要路径
            /* 开始主循环，每次求得v0到某个顶点v的最短路径*/
            for (v = 1; v < G.vexNum; v++)
            {
                min = INFINITY;						// 当前所知离v0顶点的最近距离
                for (w = 0; w < G.vexNum; w++)		// 寻找离v0最近的顶点
                {
                    if (!final[w] && dist[w] < min)
                    {
                        k = w;
                        min = dist[w];				// w顶点离v0顶点更近
                    }
                }
                final[k] = 1;						// 将目前找到的最近的顶点置为1
                for (w = 0; w < G.vexNum; w++)		// 修正当前最短路径及距离
                {
                    /* 如果经过v顶点的路径比现在这条路径的长度短的话 */
                    if (!final[w] && (min + G.Edge[k][w] < dist[w]))
                    {
                        /* 找到了更短的路径，修改D[w]和P[w] */
                        dist[w] = min + G.Edge[k][w];	// 修改当前路径长度
                        path[w] = k;
                    }
                }
            }
        }
    }

}
