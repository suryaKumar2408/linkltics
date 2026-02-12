import { useQuery } from "react-query";
import api from "../api/api";

export const useFetchMyShortUrls = (token, onError) => {
  return useQuery(
    "my-shortenurls",
    async () => {
      return await api.get("/api/urls/myurls", {
        headers: {
          "Content-Type": "application/json",
          Accept: "application/json",
          Authorization: "Bearer " + token,
        },
      });
    },
    {
      select: (data) => {
        const sortedData = data.data.sort(
          (a, b) => new Date(b.createdDate) - new Date(a.createdDate)
        );
        return sortedData;
      },
      onError,
      staleTime: 5000,
    }
  );
};

export const useFetchTotalClicks = (token, onError) => {
  const today = new Date();
  const year = today.getFullYear();

  const startDate = `${year}-01-01`;
  const endDate = `${year}-12-31`;

  return useQuery(
    ["url-totalclick", startDate, endDate],
    async () => {
      return await api.get(
        `/api/urls/totalClicks?startDate=${startDate}&endDate=${endDate}`,
        {
          headers: {
            "Content-Type": "application/json",
            Accept: "application/json",
            Authorization: "Bearer " + token,
          },
        }
      );
    },
    {
      select: (data) => {
        return Object.keys(data.data).map((key) => ({
          clickDate: key,
          count: data.data[key],
        }));
      },
      onError,
      staleTime: 5000,
    }
  );
};
