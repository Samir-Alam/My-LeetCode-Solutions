![Logo](https://assets.leetcode.com/static_assets/public/webpack_bundles/images/logo-dark.e99485d9b.svg)

# <font color="red">Explanations of this question :- </font>

> Let's update dp as we consider each station in order. With no stations, clearly we can get a maximum distance of startFuel with 0 refueling stops.

> Now let's look at the update step. When adding a station station[i] = (location, capacity), any time we could reach this station with t refueling stops, we can now reach capacity further with t+1 refueling stops.

> For example, if we could reach a distance of 15 with 1 refueling stop, and now we added a station at location 10 with 30 liters of fuel, then we could potentially reach a distance of 45 with 2 refueling stops.



# Approach 2: Heap

>### Intuition :-
> When driving past a gas station, let's remember the amount of fuel it contained. We don't need to decide yet whether to fuel up here or not - for example, there could be a bigger gas station up ahead that we would rather refuel at.
>
> When we run out of fuel before reaching the next station, we'll retroactively fuel up: greedily choosing the largest gas stations first.
>
> This is guaranteed to succeed because we drive the largest distance possible before each refueling stop, and therefore have the largest choice of gas stations to (retroactively) stop at.

> ## Algorithm :-
> pq ("priority queue") will be a max-heap of the capacity of each gas station we've driven by. We'll also keep track of tank, our current fuel.
>
> When we reach a station but have negative fuel (ie. we needed to have refueled at some point in the past), we will add the capacities of the largest gas stations we've driven by until the fuel is non-negative.
>
> If at any point this process fails (that is, no more gas stations), then the task is impossible.
