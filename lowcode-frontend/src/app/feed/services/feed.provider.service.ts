import { Injectable } from "@angular/core";
import { FeedItem, feedItemMocks } from "../models/feed-item.model";
import { BehaviorSubject } from "rxjs";

import { ApiService } from "../../api/api.service";

@Injectable({
  providedIn: "root",
})
export class FeedProviderService {
  currentFeed$: BehaviorSubject<FeedItem[]> = new BehaviorSubject<FeedItem[]>(
    []
  );

  constructor(private api: ApiService) {}

  async createUserStory(userStory: object): Promise<any> {
    const res = await this.api.post("/user-stories", userStory);
    const feed = [res, ...this.currentFeed$.value];
    this.currentFeed$.next(feed);
    return res;
  }

  async getUserStory(): Promise<BehaviorSubject<FeedItem[]>> {
    const res = await this.api.get("/user-stories");
    const items = <FeedItem[]>res;
    this.currentFeed$.next(items);
    return Promise.resolve(this.currentFeed$);
  }

  async uploadFeedItem(caption: string, file: File): Promise<any> {
    const res = await this.api.upload("/feed", file, {
      caption: caption,
      url: file.name,
    });
    const feed = [res, ...this.currentFeed$.value];
    this.currentFeed$.next(feed);
    return res;
  }
}
