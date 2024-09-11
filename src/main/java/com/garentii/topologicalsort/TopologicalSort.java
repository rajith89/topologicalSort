package com.garentii.topologicalsort;

import java.util.*;

public class TopologicalSort {

    public static List<Integer> sortScripts(List<VulnerabilityScript> scripts) {
        // Build the graph and compute in-degrees
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();

        // Initialize the graph and dependency list for scripts
        for (VulnerabilityScript script : scripts) {
            int scriptId = script.getScriptId();
            graph.putIfAbsent(scriptId, new ArrayList<>());
            inDegree.putIfAbsent(scriptId, 0);
            for (int dependency : script.getDependencies()) {
                graph.putIfAbsent(dependency, new ArrayList<>());
                graph.get(dependency).add(scriptId);
                inDegree.put(scriptId, inDegree.getOrDefault(scriptId, 0) + 1);
            }
        }

        // Find all nodes with zero depedencies
        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }

        // Perform topological sorting of nodes
        List<Integer> sortedScripts = new ArrayList<>();
        while (!queue.isEmpty()) {
            int scriptId = queue.poll();
            sortedScripts.add(scriptId);

            for (int neighbor : graph.getOrDefault(scriptId, new ArrayList<>())) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // Check for cycles (if sortedScripts size is not equal to number of scripts)
        if (sortedScripts.size() != scripts.size()) {
            throw new IllegalArgumentException("The graph has at least one circular dependencies.");
        }

        return sortedScripts;
    }
}
